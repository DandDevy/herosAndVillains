package models.Buffers;

import models.people.villains.SuperVillain;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <h1>Buffer implements models.util.Buffer</h1>
 * <p>This Buffer is for my producer consumer pattern.</p>
 */
public class Buffer implements models.util.Buffer {
    private final LinkedList<SuperVillain> buffer;
    private ReentrantLock bufferLock = new ReentrantLock(true);

    private int maxBufferSizeAllowed = 4;

    private Condition notFull = bufferLock.newCondition();
    private Condition notEmpty = bufferLock.newCondition();

    public Buffer() { this.buffer = new LinkedList<SuperVillain>(); }

    public Buffer(int maxBufferSizeAllowed) {
        this.buffer = new LinkedList<SuperVillain>();
        this.maxBufferSizeAllowed = maxBufferSizeAllowed;
    }

    /**
     * <p>Set a SuperVillain in the buffer of a limited size.</p>
     * @param villain
     * @throws InterruptedException
     */
    @Override
    public void set(SuperVillain villain) throws InterruptedException {
        bufferLock.lock();
        try {
            while (buffer.size() == maxBufferSizeAllowed){
                notFull.await();
            }
            buffer.push(villain);
            notFull.signalAll();
        } finally {
            bufferLock.unlock();
        }

    }

    /**
     * <p>Gets a SuperVillain from the buffer of a limited size..</p>
     * @return SuperVillain
     * @throws InterruptedException
     */
    @Override
    public SuperVillain get() throws InterruptedException {
        bufferLock.lock();

        SuperVillain villainToReturn = null;
        try {

            while (buffer.size() == 0){
                notEmpty.await();
            }

            villainToReturn = buffer.pop();
            notEmpty.signalAll();

            return villainToReturn;

        } finally {
            bufferLock.unlock();
        }

    }
}
