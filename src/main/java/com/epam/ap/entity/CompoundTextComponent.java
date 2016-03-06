package com.epam.ap.entity;

import java.util.*;

public abstract class CompoundTextComponent<E extends TextComponent> implements TextComponent, Iterable<E> {
    List<E> components = new ArrayList<>();
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public void toPlainString(StringBuilder sb) {
        for (E e : components) {
            e.toPlainString(sb);
        }
    }

    public void add(E e) {
        components.add(e);
    }

    public boolean remove(E e) {
        return components.remove(e);
    }

    public int getCount(Type c) {
        int result = 0;

        if (type == c) result += 1;
        else for (E component : components) {
            result += component.getCount(c);
        }

        return result;

    }

    @Override
    public String toString() {
        return "Component{" +
                "components=" + components +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompoundTextComponent<?> that = (CompoundTextComponent<?>) o;

        return components.equals(that.components);

    }

    @Override
    public int hashCode() {
        return components.hashCode();
    }

    @SuppressWarnings("unchecked")
    public Iterator<TextComponent> getIterator(Type type) {
        return new TextComponentDeepIterator(this, type);
    }

    @Override
    public Iterator<E> iterator() {
        return components.iterator();
    }

    private class TextComponentDeepIterator<T extends TextComponent> implements Iterator<TextComponent> {
        final Stack<Iterator<?>> stack = new Stack<>();
        Type typeToIterateOn;
        T nextElement;


        private TextComponentDeepIterator(CompoundTextComponent<T> t, Type type) {
            typeToIterateOn = type;
            if (t == null) {
                throw new NullPointerException("Can't iterate over null component"); //todo: create own exception
            }
            stack.push(t.iterator());
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean hasNext() {
            if (nextElement != null) {
                return true;
            }
            while (!stack.isEmpty()) {
                Iterator<?> iterator = stack.peek();
                if (iterator.hasNext()) {
                    TextComponent next = (TextComponent) iterator.next();
                    if (next.getType() != typeToIterateOn) {
                        if ((next.getType() != Type.PUNCTUATION) &&
                                (next.getType() != Type.WORD_SYMBOL) &&
                                (next.getType() != Type.WHITESPACE)) {
                            stack.push(((CompoundTextComponent) next).iterator());
                        }
                    } else {
                        nextElement = (T) next;
                        return true;
                    }
                } else {
                    stack.pop();
                }
            }

            return false;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T toReturn = nextElement;
                nextElement = null;
                return toReturn;
            }

            throw new NoSuchElementException();
        }
    }
}