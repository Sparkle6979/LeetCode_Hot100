//
// 请你设计并实现一个满足 
// LRU (最近最少使用) 缓存 约束的数据结构。
// 
//
// 
// 实现 
// LRUCache 类：
// 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
// 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 2671 👎 0




import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

//leetcode submit region begin(Prohibit modification and deletion)


class LRUCache {

    class DList{
        int key;
        int val;
        DList pre;
        DList next;

        public DList(int k,int v,DList l1,DList l2){
            key = k;val = v; pre = l1; next = l2;
        }

        public DList(){}
//        public Dlist(int v){val = v;}

    }

    Map<Integer,DList> rec = new HashMap<>();
    DList head;
    DList tail;
    int size;
    int capacity;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        // 使用伪头部和伪结尾
        head = new DList();
        tail = new DList();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DList node = rec.getOrDefault(key,null);
        if(node == null)
            return -1;

        // 把这个节点放到头节点，代表最先使用的
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DList node = rec.getOrDefault(key,null);
        if(node != null){
            node.val = value;
            moveToHead(node);
            return;
        }else{
            if(size == capacity) {
                DList oldtail = removeTail();
                rec.remove(oldtail.key);
                size--;
            }

            DList tmp = new DList(key,value,null,null);


            // 直接插入头部
            tmp.next = head.next;
            tmp.pre = head;
            head.next = tmp;
            tmp.next.pre = tmp;

            rec.put(key,tmp);
            size++;

        }

    }

    private void moveToHead(DList node){
        DList nodepre = node.pre;
        DList nodenxt = node.next;
        nodepre.next = node.next;
        nodenxt.pre = node.pre;


        node.next = head.next;
        node.pre = head;
        head.next = node;
        node.next.pre = node;
    }

    /**
     * 返回删除的元素
     * @return
     */
    private DList removeTail(){
        DList tailpre = tail.pre;
        DList tailprepre = tailpre.pre;
        tailprepre.next = tail;
        tail.pre = tailprepre;
        return tailpre;
    }
}

//class LRUCache {
//
//
//    private Map<Integer,Pair<Integer,Integer>> rec;
//    private int nowcnt;
//    private int capacity;
//
//
//    public LRUCache(int capacity) {
//        this.rec = new HashMap<>();
//        this.nowcnt = 0;
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        if(rec.containsKey(key)) {
//            // map 有 replace 方法
//            Pair<Integer, Integer> tmp = rec.get(key);
//            rec.replace(key,new ImmutablePair<Integer,Integer>(tmp.getLeft(),tmp.getRight()+1));
//
//            return tmp.getLeft();
//        }
//        else
//            return -1;
//    }
//
//    public void put(int key, int value) {
//        if(rec.containsKey(key)){
//            rec.put(key,new ImmutablePair<Integer,Integer>(value,1));
//        }else {
//            if(nowcnt == capacity){
//                int LeastKey = getLeastKey();
//                rec.remove(LeastKey);
//            }
//            rec.put(key,new ImmutablePair<Integer,Integer>(value,1));
//            nowcnt += 1;
//
//        }
//    }
//
//    public int getLeastKey(){
//        int minr = Integer.MAX_VALUE;
//        int mink = -1;
//        for (Integer integer : rec.keySet()) {
//            int val = rec.get(integer).getRight().intValue();
//            if(val < minr){
//                mink = integer.intValue();
//                minr = val;
//            }
//        }
//        return mink;
//    }
//}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
