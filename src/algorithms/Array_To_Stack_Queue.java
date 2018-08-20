package algorithms;


/*
数组实现栈和队列
 */
public class Array_To_Stack_Queue {

    public static class ArrayStack{
        Integer[] array;
        Integer size = 0;

        public ArrayStack(Integer init){
            if (init < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            array = new Integer[init];
            size = 0;
        }

        public void push(int a){
            if(size >= array.length){
                throw new IndexOutOfBoundsException("栈满了");
            }
            array[size ++] = a;
        }
        public int pop(){
            if(size == 0){
                throw new IndexOutOfBoundsException("栈为空");
            }
            return array[-- size];
        }
        public int peek(){
            if(size == 0){
                throw new IndexOutOfBoundsException("栈为空");
            }
            return array[size - 1];
        }
        public boolean isEmpty(){
            return size == 0;
        }
    }

    public static class ArrayQueue{

        Integer[] array;
        Integer size;
        Integer first;
        Integer last;

        public ArrayQueue(Integer init){
            if (init < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }

            array = new Integer[init];
            size = 0;
            first = 0;
            last = 0;
        }

        public void push(Integer a){
            if(size == array.length){
                throw new IndexOutOfBoundsException("队列满了");
            }
            size ++;
            last = last == array.length - 1 ? 0: last;
            array[last ++] = a;

        }
        public Integer poll(){
            if(size == 0){
                throw new IndexOutOfBoundsException("队列为空");
            }
            size --;
            int temp = array[first ++];
            first = first == array.length - 1 ? 0 : first;
            return temp;
        }
        public Integer peek(){
            if(size == 0){
                throw new IndexOutOfBoundsException("队列为空");
            }
            return array[first];
        }
        public boolean isEmpty(){
            return size == 0;
        }
    }

    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        ArrayQueue queue = new ArrayQueue(10);
        ArrayStack stack = new ArrayStack(10);
        for(int b : a){
            queue.push(b);
            stack.push(b);
        }

        while (!queue.isEmpty()){
            System.out.print(queue.poll()+" ");
        }

        System.out.println();

        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
