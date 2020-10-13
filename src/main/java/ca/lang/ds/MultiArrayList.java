package ca.lang.ds;

/**
 * 
 * @author Renato Raeffray
 * 
 *         Create a dynamic array with multiple arrays
 * 
 *         Avoid recreating the entire array containing the data, rather
 *         creating a new portion of array and keep the index for that
 *
 * 
 */
public class MultiArrayList<T> {

	private T[][] _array;

	private int _numberOfArrays = 10;

	private int _arrayMaxCapacity = 10;

	public MultiArrayList() {
		this._array = (T[][]) new Object[_numberOfArrays + 1][_arrayMaxCapacity];
	}

	public MultiArrayList(int size) {
		this._numberOfArrays = size / _arrayMaxCapacity;
		this._array = (T[][]) new Object[this._numberOfArrays + 1][this._arrayMaxCapacity];
	}

	public MultiArrayList(int size, int maxSubSet) {
		this._arrayMaxCapacity = maxSubSet;
		this._numberOfArrays = size / _arrayMaxCapacity;
		this._array = (T[][]) new Object[this._numberOfArrays + 1][this._arrayMaxCapacity];
	}

	private int currentArray(int index) {
		return index / this._arrayMaxCapacity;
	}

	private int currentPosition(int index) {
		return index % this._arrayMaxCapacity;
	}

	private void resize(int index) {
		int newSize = (index / this._arrayMaxCapacity);
		if ((newSize - this._numberOfArrays) > 0) {
			T[][] newArray = (T[][]) new Object[newSize + 1][this._arrayMaxCapacity];
			for (int i = 0; i < this._array.length; i++) {
				newArray[i] = this._array[i];
			}
			this._numberOfArrays = newSize;
			this._array = newArray;
		}
	}

	public void add(int index, T value) {
		resize(index);
		this._array[currentArray(index)][currentPosition(index)] = value;
	}

	public T get(int index) {
		return this._array[currentArray(index)][currentPosition(index)];
	}

}
