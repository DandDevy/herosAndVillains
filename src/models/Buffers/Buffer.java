package models.Buffers;

import models.people.villains.SuperVillain;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer implements models.util.Buffer {
    private final LinkedList<SuperVillain> buffer;
    private ReentrantLock bufferLock = new ReentrantLock(true);

    private int maxBufferSizeAllowed = 4;
    private int occupiedCellsForBuffer = 0;

    private Condition notFull = bufferLock.newCondition();
    private Condition notEmpty = bufferLock.newCondition();

    public Buffer() { this.buffer = new LinkedList<SuperVillain>(); }

    public Buffer(int maxBufferSizeAllowed) {
        this.buffer = new LinkedList<SuperVillain>();
        this.maxBufferSizeAllowed = maxBufferSizeAllowed;
    }

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
