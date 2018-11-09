public class BinaryHeap {

    int[] arr;
    int size;

    public BinaryHeap(){
        arr = new int[10];
        size = 0;
    }

    public void growArray(){
        int[] newArr = new int[arr.length * 2];
        int i = 0;
        while(i < arr.length){
            newArr[i] = arr[i];
            i++;
        }
        arr = newArr;
    }

    public void swap(int a, int b, int [] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void add(int pri){

        if(size == arr.length - 1){
            growArray();
        }
        arr[size] = pri;
        //System.out.println(arr[0]);
        ++size;
        int index = size-1;
        int parent = (index - 1)/2;
        while(index >= 0 && arr[index] < arr[parent]){
            swap(index, parent, arr);
            index = parent;
            parent = (index-1)/2;
        }

    }

    public void shiftdown(int parent){

        int child = (parent * 2)+1;
        if(child > size || arr[parent] < arr[child]){
            return;
        }

        if(arr[child+1] < arr[child]){
            child++;
        }
        if(arr[parent] > arr[child]){
            swap(child, parent, arr);
            shiftdown(child);
        }

    }

    public int remove(){
        int pri = arr[0];
        arr[0] = arr[--size];
        shiftdown(0);
        return pri;
    }
}
