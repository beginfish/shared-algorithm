package com.bamdow.sharedalgorithm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ObjectTopK<E> {

	//要排序的数量
    private int k;
    //数据存储
    private List<E> list;
    //比较器
    private Comparator comparator;
    //是否初始化堆
    private boolean init=false;
    
    public ObjectTopK(int k){
		this.k = k;
		//初始化大小
		list = new ArrayList<E>(k);
	}
	
	public ObjectTopK(int k,Comparator<? super E> comparator){
		this.k = k;
		//初始化大小
		list = new ArrayList<E>(k);
		this.comparator = comparator;
	}
	
	/**
	 * 添加元素
	 * @param e
	 */
	public void add(E e) {
		if( list.size() < k ) {
			list.add(e);
		}else if( !init ){
			buildMinHeap();
			init=true;
		}else {
			if( comparator != null && comparator.compare(e, list.get(0)) > 0) {
				list.set(0, e);
				buildMinHeap(0, list.size());
			}else if(((Comparable)e).compareTo((Comparable)list.get(0)) > 0) {
				list.set(0, e);
				buildMinHeap(0, list.size());
			}
			
		}
	}
	/**
	 * 构造最小堆
	 */
	private void buildMinHeap(){
		for(int i=list.size()/2 -1 ; i>=0 ; i--) {
			buildMinHeap(i, list.size());
//			print();
//			System.out.println();
		}
	}
	
	/**
	 * 堆化
	 */
	private void buildMinHeap(int start, int end) {
		if( comparator != null ) {
			int left = 2*start+1;
			while(left < end) {
				int min = left;
				if( left+1 < end && comparator.compare(list.get(left+1), list.get(left))<0){
					min = left+1;
				}
				if(comparator.compare(list.get(start), list.get(min))<0) {
					break;
				} else {
					E temp = list.get(min);
					list.set(min, list.get(start));
					list.set(start, temp);
					start = min;
					left = 2*start + 1;
				}
			}
		}else if( list.get(0) instanceof Comparable){
			int left = 2*start+1;
			while(left < end) {
				int min = left;
				if( left+1 < end && ((Comparable)list.get(left+1)).compareTo((Comparable)list.get(left)) < 0){
					min = left+1;
				}
				if( ((Comparable)list.get(start)).compareTo((Comparable)list.get(min)) < 0 ) {
					break;
				} else {
					E temp = list.get(min);
					list.set(min, list.get(start));
					list.set(start, temp);
					start = min;
					left = 2*start + 1;
				}
			}
		} else {
			throw new RuntimeException("数据不能比较");
		}
	}
	
	/**
	 * 堆排序
	 */
	public void sort() {
		for(int i=list.size()-1; i>=0; i--) {
			E temp = list.get(0);
			list.set(0, list.get(i));
			list.set(i, temp);
			buildMinHeap(0, i);
		}
	}
	
	/**
	 * 输出结果
	 */
	public void print() {
		for(E e: list) {
			System.out.print(e+" ");
		}
	}
	public static void main(String[] args) throws IOException {
		ObjectTopK<Integer> obj = new ObjectTopK<Integer>(50);
		Random random = new Random();
		long start = System.currentTimeMillis();
		for(int i=0;i<Integer.MAX_VALUE;i++) {
			obj.add(random.nextInt(Integer.MAX_VALUE));
		}
		obj.sort();
		obj.print();
		System.out.println("=============================");
		System.out.println("21亿数据耗时："+(System.currentTimeMillis()-start)/1000);
	}
	
}
