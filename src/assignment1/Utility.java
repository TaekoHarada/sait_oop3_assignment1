package assignment1;

import java.util.Comparator;

//import shapes.ThreeDShape;
import java.util.*;

/**
* Utility class provides sorting algorithm methods.
* The utility class must sort a collection of Comparables (from instruction doc).
*/
public class Utility {
	
	/**
     * Sorts the given array using the specified sorting algorithm and comparator.
     *
     * @param <T> the type of elements in the array, which must implement Comparable
     * @param sortAlgorithm the sorting algorithm to use ('b' for bubble sort, 's' for selection sort,
     *                      'i' for insertion sort, 'm' for merge sort, 'q' for quick sort, 'z' for heap sort)
     * @param array the array to be sorted
     * @param comparator the comparator to determine the order of the array
     */
	public static <T extends Comparable<T>> void sort(String sortAlgorithm, T[] array, Comparator<? super T> comparator) {
		switch (sortAlgorithm) {
			case "b":
				bubbleSort(array, comparator);
				break;
			case "s":
				selectionSort(array, comparator);
				break;
			case "i":
				insertionSort(array, comparator);
				break;
			case "m":
				mergeSort(array, comparator);
				break;
			case "q":
				quickSort(array, comparator);
				break;
			case "z":
				heapSort(array, comparator);
				break;
		}
	}
		


	/**
     * Sorts the given array using Bubble sort.
     *
     * @param <T> the type of elements in the array, which must implement Comparable
     * @param array the array to be sorted
     * @param comparator the comparator to determine the order of the array
     */
	private static <T extends Comparable<T>> void bubbleSort(T[] array, Comparator<? super T> comparator) {
	    int n = array.length;
	    boolean swapped;
	    do {
	        swapped = false;
	        for (int i = 0; i < n - 1; i++) {
	            // Using the provided comparator for comparison
	            if (comparator.compare(array[i], array[i + 1]) > 0) {
	                T temp = array[i];
	                array[i] = array[i + 1];
	                array[i + 1] = temp;
	                swapped = true;
	            }
	        }
	    } while (swapped);
	}
	
	/**
     * Sorts the given array using Insertion sort.
     *
     * @param <T> the type of elements in the array, which must implement Comparable
     * @param array the array to be sorted
     * @param comparator the comparator to determine the order of the array
     */
	private static <T extends Comparable<T>> void insertionSort(T[] array, Comparator<? super T> comparator) {
	    int n = array.length;
	    for (int i = 1; i < n; i++) {
	        T key = array[i];
	        int j = i - 1;
	        while (j >= 0 && comparator.compare(array[j], key) > 0) {
	            array[j + 1] = array[j];
	            j = j - 1;
	        }
	        array[j + 1] = key;
	    }
	}
	
	/**
     * Sorts the given array using Selection sort.
     *
     * @param <T> the type of elements in the array, which must implement Comparable
     * @param array the array to be sorted
     * @param comparator the comparator to determine the order of the array
     */
	private static <T extends Comparable<T>> void selectionSort(T[] array, Comparator<? super T> comparator) {
	    int n = array.length;
	    for (int i = 0; i < n - 1; i++) {
	        int minIndex = i;
	        for (int j = i + 1; j < n; j++) {
	            if (comparator.compare(array[j], array[minIndex]) < 0) {
	                minIndex = j;
	            }
	        }
	        T temp = array[minIndex];
	        array[minIndex] = array[i];
	        array[i] = temp;
	    }
	}
	
	/**
     * Sorts the given array using Merge sort.
     *
     * @param <T> the type of elements in the array, which must implement Comparable
     * @param array the array to be sorted
     * @param comparator the comparator to determine the order of the array
     */
	private static <T extends Comparable<T>> void mergeSort(T[] array, Comparator<? super T> comparator) {
	    mergeSort(array, 0, array.length - 1, comparator);
	}

	/**
     * Recursively sorts the given subarray using merge sort algorithm.
     *
     * @param <T> the type of elements in the array, which must implement Comparable
     * @param array the array to be sorted
     * @param low the starting index of the subarray to be sorted
     * @param high the ending index of the subarray to be sorted
     * @param comparator the comparator to determine the order of the array
     */
	private static <T extends Comparable<T>> void mergeSort(T[] array, int low, int high, Comparator<? super T> comparator) {
	    if (low < high) {
	        int mid = (low + high) / 2;
	        mergeSort(array, low, mid, comparator);
	        mergeSort(array, mid + 1, high, comparator);
	        merge(array, low, mid, high, comparator);
	    }
	}

	/**
     * Merges two sorted subarrays into one sorted subarray.
     *
     * @param <T> the type of elements in the array, which must implement Comparable
     * @param array the array to be sorted
     * @param low the starting index of the first subarray
     * @param mid the ending index of the first subarray
     * @param high the ending index of the second subarray
     * @param comparator the comparator to determine the order of the array
     */
	private static <T extends Comparable<T>> void merge(T[] array, int low, int mid, int high, Comparator<? super T> comparator) {
	    T[] leftArray = Arrays.copyOfRange(array, low, mid + 1);
	    T[] rightArray = Arrays.copyOfRange(array, mid + 1, high + 1);

	    int i = 0, j = 0, k = low;
	    while (i < leftArray.length && j < rightArray.length) {
	        if (comparator.compare(leftArray[i], rightArray[j]) <= 0) {
	            array[k++] = leftArray[i++];
	        } else {
	            array[k++] = rightArray[j++];
	        }
	    }

	    while (i < leftArray.length) {
	        array[k++] = leftArray[i++];
	    }

	    while (j < rightArray.length) {
	        array[k++] = rightArray[j++];
	    }
	}
	
	
	/**
     * Sorts the given array using Quick sort.
     *
     * @param <T> the type of elements in the array, which must implement Comparable
     * @param array the array to be sorted
     * @param comparator the comparator to determine the order of the array
     */
	private static <T extends Comparable<T>> void quickSort(T[] array, Comparator<? super T> comparator) {
	    quickSort(array, 0, array.length - 1, comparator);
	}

	/**
     * Recursively sorts the given subarray using quick sort algorithm.
     *
     * @param <T> the type of elements in the array, which must implement Comparable
     * @param array the array to be sorted
     * @param low the starting index of the subarray to be sorted
     * @param high the ending index of the subarray to be sorted
     * @param comparator the comparator to determine the order of the array
     */
	private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high, Comparator<? super T> comparator) {
	    if (low < high) {
	        int pi = partition(array, low, high, comparator);
	        quickSort(array, low, pi - 1, comparator);
	        quickSort(array, pi + 1, high, comparator);
	    }
	}
	
	/**
     * Partitions the given subarray around a pivot element.
     *
     * @param <T> the type of elements in the array, which must implement Comparable
     * @param array the array to be sorted
     * @param low the starting index of the subarray
     * @param high the ending index of the subarray
     * @param comparator the comparator to determine the order of the array
     * @return the index of the pivot element after partitioning
     */
	private static <T extends Comparable<T>> int partition(T[] array, int low, int high, Comparator<? super T> comparator) {
	    T pivot = array[high];
	    int i = low - 1;
	    for (int j = low; j < high; j++) {
	        if (comparator.compare(array[j], pivot) <= 0) {
	            i++;
	            T temp = array[i];
	            array[i] = array[j];
	            array[j] = temp;
	        }
	    }
	    T temp = array[i + 1];
	    array[i + 1] = array[high];
	    array[high] = temp;
	    return i + 1;
	}

	/**
	 * Sorts the given array using Heap sort algorithm.
	 *
	 * @param <T> the type of elements in the array, which must implement Comparable
	 * @param array the array to be sorted
	 * @param comparator the comparator to determine the order of the array
	 */
	private static <T extends Comparable<T>> void heapSort(T[] array, Comparator<? super T> comparator) {
	    int n = array.length;
	    for (int i = n / 2 - 1; i >= 0; i--) {
	        heapify(array, n, i, comparator);
	    }
	    for (int i = n - 1; i >= 0; i--) {
	        T temp = array[0];
	        array[0] = array[i];
	        array[i] = temp;
	        heapify(array, i, 0, comparator);
	    }
	}
	
	/**
	 * Converts a subtree rooted with node i into a max heap, assuming the subtrees are already heaps.
	 *
	 * @param <T> the type of elements in the array, which must implement Comparable
	 * @param array the array representing the heap
	 * @param n the size of the heap
	 * @param i the root index of the subtree to heapify
	 * @param comparator the comparator to determine the order of the array
	 */
	private static <T extends Comparable<T>> void heapify(T[] array, int n, int i, Comparator<? super T> comparator) {
	    int largest = i;
	    int left = 2 * i + 1;
	    int right = 2 * i + 2;
	    if (left < n && comparator.compare(array[left], array[largest]) > 0) {
	        largest = left;
	    }
	    if (right < n && comparator.compare(array[right], array[largest]) > 0) {
	        largest = right;
	    }
	    
        if (largest != i) {
        	T temp = array[i];
        	array[i] = array[largest];
        	array[largest] = temp;
        	heapify(array, n, largest, comparator);
        }
	}
	
}
