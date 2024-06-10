package assignment1;

import java.util.Comparator;

//import shapes.ThreeDShape;
import java.util.*;

// Sorting algorithms
// The utility class must sort a collection of Comparables.
public class Utility {
	
	// All Sort
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
		

	// Bubble
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
	
	// Insertion
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
	
	// Selection Sort
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
	
	// Merge Sort
	private static <T extends Comparable<T>> void mergeSort(T[] array, Comparator<? super T> comparator) {
	    mergeSort(array, 0, array.length - 1, comparator);
	}

	private static <T extends Comparable<T>> void mergeSort(T[] array, int low, int high, Comparator<? super T> comparator) {
	    if (low < high) {
	        int mid = (low + high) / 2;
	        mergeSort(array, low, mid, comparator);
	        mergeSort(array, mid + 1, high, comparator);
	        merge(array, low, mid, high, comparator);
	    }
	}

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
	
	
	// Quick Sort
	private static <T extends Comparable<T>> void quickSort(T[] array, Comparator<? super T> comparator) {
	    quickSort(array, 0, array.length - 1, comparator);
	}

	private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high, Comparator<? super T> comparator) {
	    if (low < high) {
	        int pi = partition(array, low, high, comparator);
	        quickSort(array, low, pi - 1, comparator);
	        quickSort(array, pi + 1, high, comparator);
	    }
	}
	
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

	// A sorting algorithm of your choice
    // Heap
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
