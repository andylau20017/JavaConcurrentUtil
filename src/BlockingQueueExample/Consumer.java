/**
 * 
 */
package BlockingQueueExample;

import java.util.concurrent.BlockingQueue;

/**
 * @author erfeiliu
 * 
 *A BlockingQueue has 4 different sets of methods for inserting, removing and examining the elements in the queue. Each set of methods behaves differently in case the requested operation cannot be carried out immediately. Here is a table of the methods:

    Throws Exception    Special Value   Blocks  Times Out
Insert  add(o)  offer(o)    put(o)  offer(o, timeout, timeunit)
Remove  remove(o)   poll(o) take(o) poll(timeout, timeunit)
Examine element(o)  peek(o)      
The 4 different sets of behaviour means this:

Throws Exception: 
If the attempted operation is not possible immediately, an exception is thrown.
Special Value: 
If the attempted operation is not possible immediately, a special value is returned (often true / false).
Blocks: 
If the attempted operation is not possible immedidately, the method call blocks until it is.
Times Out: 
If the attempted operation is not possible immedidately, the method call blocks until it is, but waits no longer than the given timeout. Returns a special value telling whether the operation succeeded or not (typically true / false).
 */
public class Consumer implements Runnable{

    protected BlockingQueue queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
