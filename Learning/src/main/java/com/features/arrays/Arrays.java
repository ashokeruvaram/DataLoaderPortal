package com.features.arrays;

public class Arrays {

	public void peakOfNeighbor() {
		int arry[] = { 10, 20, 15, 2, 23, 99, 67 };
		int peekValue = 0;
		int difference = 0;
		for (int i = 0; i < arry.length - 1; i++) {
			if (i == 0 && arry[i] > arry[i + 1]) {
				difference = arry[i] - arry[i + 1];
				peekValue = arry[i];
			}
			if (i > 0 && arry[i] > arry[i - 1]) {
				int diff = arry[i] - arry[i - 1];
				if (i != arry.length - 1 && arry[i] > arry[i + 1])
					diff += arry[i] - arry[i + 1];
				if (difference < diff) {
					difference = diff;
					peekValue = arry[i];
				}

			}
		}
		System.out.println(peekValue);

	}

	public void linearSort() {
		int[] a = { 10, 20, 15, 2, 23, 99, 67 };
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i] < a[j]) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}

	public void quickSorting(int c[], int low, int high) {

		int mid = (low + high) / 2;
		int i = 0;
		int j = high;
		int pivote = c[mid];
		while (i <= j) {
			while (c[i] < pivote) {
				i++;
			}
			while (c[j] > pivote) {
				j--;
			}
			if (i <= j) {
				int temp = c[i];
				c[i] = c[j];
				c[j] = temp;
				i++;
				j--;
			}
		}
		if (low < j)
			quickSorting(c, low, j);
		if (high > i)
			quickSorting(c, i, high);
	}

	public void quickSort() {
		int c[] = { 6, 4, 6, 3, 6, 8, 9, 5, 3, 1 };
		quickSorting(c, 0, c.length - 1);
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + " ");
		}
	}

	public void bubbleSort() {
		int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}

	public void selectionSort() {
		int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		for (int i = 0; i < a.length - 1; i++) {
			int small = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[small] > a[j]) {
					small = j;
				}
			}
			int temp = a[small];
			a[small] = a[i];
			a[i] = temp;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}

	public void insertionSort() {
		int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		for (int i = 1; i < a.length - 1; i++) {
			int small = i;
			for (int j = i - 1; j >= 0; j--) {
				if (a[small] < a[j]) {
					a[j] = a[i - 1];
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}

}
