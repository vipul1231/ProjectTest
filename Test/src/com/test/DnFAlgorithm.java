package com.test;

/**
 * Dutch national flag algorithm
 * 
 * @author vtiwari
 *
 */
public class DnFAlgorithm {

	int[] array1 = { 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1 };
	int[] array2 = { 0, 1, 0, 0, 1, 2, 1, 1, 2, 1, 1, 2, 1, 0, 0 };

	public static void main(String[] args) {

		DnFAlgorithm dnFAlgorithm = new DnFAlgorithm();
		dnFAlgorithm.arraySort();
		dnFAlgorithm.arraySortWithThreeIndex();
	}

	private void arraySortWithThreeIndex() {

		int i = -1, j = -1, k = -1;
		for (int m = 0; m < array2.length; m++) {

			int value = array2[m];

			switch (value) {

			case 0:
				if (i == -1) {
					i = m;
					continue;
				}

				if (k != -1 && k < m) {
					array2[j + 1] = 0;
					array2[m] = 2;
					
					array2[i + 1] = 0;
					array2[j + 1] = 1;
					i++;
					k++;
					j++;
				} else if (j != -1 && j < m) {

					array2[i + 1] = 0;
					array2[m] = 1;
					i++;
					j++;
				}
				break;
			case 1:
				if (j == -1) {
					j = m;
					continue;
				}

				if (k != -1 && k < m) {
					array2[j + 1] = 1;
					array2[m] = 2;
					j++;
					k++;
				}
				else {
					j++;
				}
				break;
			case 2:
				if (k == -1) {
					k = m;
					continue;
				}
				k++;
				break;
			}	
		}

		System.out.println();
		for (int fm = 0; fm < array2.length; fm++) {
			System.out.print(array2[fm] + " ");
		}
		
	}

	private void arraySort() {
		int i = -1, j = -1;
		for (int k = 0; k < array1.length; k++) {

			if (array1[k] == 0) {
				if (i == -1) {
					i = k;
					continue;
				}

				if (j < k) {
					array1[i + 1] = 0;
					array1[k] = 1;
					i++;
					j++;
				}
			} else if (array1[k] == 1) {
				if (j == -1) {
					j = k;
					continue;
				}
				j++;

			}
		}

		for (int m = 0; m < array1.length; m++) {
			System.out.print(array1[m] + " ");
		}
	}
}
