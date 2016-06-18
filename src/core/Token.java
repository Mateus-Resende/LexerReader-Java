package core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Token implements Iterator{

	private List<Character> list;

	public Token(String s) {
        list = new LinkedList<>();
		for(int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));
		}
	}

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return list.listIterator().hasNext();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Character next() {
        return list.listIterator().next();
    }
}
