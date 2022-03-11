package br.com.danielbgg.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeapConstruction {

	static class MinHeap {
		List<Integer> heap = new ArrayList<Integer>();

		public MinHeap(List<Integer> array) {
			heap = buildHeap(array);
		}

		// time: O(n) | space: O(1)
		public List<Integer> buildHeap(List<Integer> array) {
			int firstParentIdx = (array.size() - 2) / 2;
			for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
				siftDown(currentIdx, array.size() - 1, array);
			}
			return array;
		}

		// time: O(logn) | space: O(1)
		public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
			int childOneIdx = currentIdx * 2 + 1;
			while (childOneIdx <= endIdx) {
				int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;

				int idxToSwap;
				if (childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) {
					idxToSwap = childTwoIdx;
				} else {
					idxToSwap = childOneIdx;
				}

				if (heap.get(idxToSwap) < heap.get(currentIdx)) {
					swap(currentIdx, idxToSwap, heap);
					currentIdx = idxToSwap;
					childOneIdx = currentIdx * 2 + 1;
				} else {
					return;
				}
			}
		}

		// time: O(logn) | space: O(1)
		public void siftUp(int currentIdx, List<Integer> heap) {
			int parentIdx = (currentIdx - 1) / 2;
			while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
				swap(currentIdx, parentIdx, heap);
				currentIdx = parentIdx;
				parentIdx = (currentIdx - 1) / 2;
			}
		}

		public int peek() {
			return heap.get(0);
		}

		// time: O(logn) | space: O(1)
		public int remove() {
			swap(0, heap.size() - 1, heap);
			int valueToRemove = heap.get(heap.size() - 1);
			heap.remove(heap.size() - 1);
			siftDown(0, heap.size() - 1, heap);
			return valueToRemove;
		}

		// time: O(logn) | space: O(1)
		public void insert(int value) {
			heap.add(value);
			siftUp(heap.size() - 1, heap);
		}

		private void swap(int i, int j, List<Integer> heap) {
			int temp = heap.get(j);
			heap.set(j, heap.get(i));
			heap.set(i, temp);
		}

	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(48);
		list.add(12);
		list.add(24);
		list.add(7);
		list.add(8);
		list.add(-5);
		list.add(24);
		list.add(391);
		list.add(24);
		list.add(56);
		list.add(2);
		list.add(6);
		list.add(8);
		list.add(41);
		new MinHeap(list);
		System.out.println(Arrays.toString(list.toArray()));
	}

}
