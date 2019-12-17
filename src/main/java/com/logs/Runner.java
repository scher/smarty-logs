package com.logs;

import java.util.PriorityQueue;

public class Runner {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(10);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
//
//        ipMap.put("ip2", 2);
//                ipMap.put("ip3", 3);
//                ipMap.put("ip4", 4);
//                ipMap.put("ip1", 10);
