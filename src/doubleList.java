public class doubleList {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(3);
        doubleLinkedList.addLast(4);
        doubleLinkedList.addLast(5);
        doubleLinkedList.display();
        System.out.println();
        System.out.println(doubleLinkedList.addIndex(0, 10));
        doubleLinkedList.display();
    }
}

class Node{
    public int data;
    public Node next;
    public Node prev;
    public Node(int data){
        this.data = data;
        this.next = null;//构造方法里面没有传入Node next的参数是因为 =null 所以可以不用传
        this.prev = null;
    }
}

class  DoubleLinkedList  {
    public Node head;//头
    public Node last;//尾
    public  DoubleLinkedList() {
        this.head = null;
        this.head = null;
    }


    //打印
    public void display(){
      Node cur = this.head;
      while (cur != null){
          System.out.print(cur.data + " ");
          cur = cur.next;
      }
    }

    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        if ( this.head == null ){
            this.head = node;
            this.last = node;
            return;
        }
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
    }



    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        if (this.last == null){
            this.head = node;
            this.last = node;
            return;
        }
        this.last.next = node;
        node.prev = this.last;
        this.last = node;
    }



    //得到链表的长度
    public int size(){
        int count = 0;
        Node cur = this.head;
        while (cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }


    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        Node node = new Node(data);
        Node cur = this.head;
        if (index < 0 || index > size()){
            return false;
        }
        if (index == 0){
            addFirst(data);
            return true;
        }
        if (index == size()){
            addLast(data);
            return true;
        }

        for (int i = 0; i < index ; i++) {
            cur = cur.next;
        }
            node.next = cur;
            node.prev = cur.prev;
            cur.prev = node;
            node.prev.next = node;
            return  true;
    }


    //删除第一次出现关键字为key的节点
    public void remove(int key){
        Node cur = this.head;
        while (cur != null) {
            if(cur.data == key) {
                //当前cur是不是头结点
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else if(cur == this.last) {
                    this.last = this.last.prev;
                    this.last.next =null;
                } else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                return;
            }else {
                cur = cur.next;
            }
        }
    }

    //删除所有值为key的节点
    public void removeAll(int key){
        Node cur = this.head;
        while (cur != null) {
            if(cur.data == key) {
                //当前cur是不是头结点
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else if(cur == this.last) {
                    this.last = this.last.prev;
                    this.last.next =null;
                } else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                return;
            }
            cur = cur.next;
        }
    }

}

/*
// 2、无头双向链表实现
public class DoubleLinkedList {
     //头插法
             public void addFirst(int data);
     //尾插法
             public void addLast(int data);
     //任意位置插入,第一个数据节点为0号下标
             public boolean addIndex(int index,int data);
     //查找是否包含关键字key是否在单链表当中
             public boolean contains(int key);
     //删除第一次出现关键字为key的节点
             public void remove(int key);
     //删除所有值为key的节点
             public void removeAllKey(int key);
     //得到单链表的长度
             public int size();
     public void display();
     public void clear();
}*/
