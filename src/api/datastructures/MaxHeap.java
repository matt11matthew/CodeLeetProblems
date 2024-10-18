package api.datastructures;

import java.util.Arrays;

public class MaxHeap {
		int[] heap;
		int size;
		
		public MaxHeap() {
			this.heap = new int[7];
			this.size = 0;
		}
		
		public MaxHeap(int[] arr) {
			this.heap = arr;
			this.size = arr.length;
			heapify();
		}
		
		public void heapify() {
			for(int i=size/2; i>=0; i--) {
				maxHeapify(i);
			}
		}
		
		public void maxHeapify(int i) {
			int left = leftIndex(i);
			int right = rightIndex(i);
			int largest = i;
			if(left < size && leftChild(i) > heap[largest]) {
				largest = left;
			}
			if(right < size && rightChild(i) > heap[largest]) {
				largest = right;
			}
			
			if(largest != i) {
				swap(i, largest);
				maxHeapify(largest);
			}
		}
		
		private void swap(int i, int j) {
			int t = heap[i];
			heap[i] = heap[j];
			heap[j] = t;
		}
		
		public void insert(int v) {
			if(this.size >= heap.length) {
				resize();
			}
			
			heap[size] = v;
			size++;
			shiftUp();
		}
		
		public void shiftUp() {
			int i = size - 1;
			
			while(hasParent(i) && parent(i) < heap[i]) {
				swap(parent(i), i);
				i = parent(i);
			}
		}
		
		public int delete() {
			if (size < 1) {
				return -1;
			}
			int top = heap[0];
			swap(0, size - 1);
			size--;
			shiftDown();
			
			return top;
		}
		
		public void shiftDown() {
			int i = 0;
			
			while(hasLeftChild(i)) {
				int smallest = leftIndex(i);
				
				if(hasRightChild(i) 
					&& rightChild(i) < leftChild(i)) {
					smallest = rightIndex(i);
				}
				
				if(heap[i] < heap[smallest]) {
					swap(i, smallest);
				}else {
					break;
				}
				
				i = smallest;
			}
		}
		
		public int size() {
			return size;
		}
		
		public void log() {
			for (int i=0; i<size; i++) {
				System.out.println(String.valueOf(heap[i]));
			}
		}
		
		private int leftIndex(int i) {
			return (2 * i) + 1;
		}
		
		private int rightIndex(int i) {
			return (2 * i) + 2;
		}
		
		private int leftChild(int i) {
			return heap[leftIndex(i)];
		}
		
		private int rightChild(int i) {
			return heap[rightIndex(i)];
		}
		
		private boolean hasLeftChild(int i) {
			return leftIndex(i) < size;
		}
		
		private boolean hasRightChild(int i) {
			return rightChild(i) < size;
		}
		
		private boolean hasParent(int i) {
			return i > 0;
		}
		
		private int parentIndex(int i) {
			return (i - 1) /2;
		}
		
		private int parent(int i) {
			return heap[parentIndex(i)];
		}
		
		private void resize() {
			this.heap = Arrays.copyOf(heap, heap.length * 2);
		}
	}