package org.practice.designPattern.behavior.iterator.runoob;

/**
 * @author yoong
 * <br>
 * @desc NameRepository
 * <br>
 * @date 2019/1/15 14:15
 */
public class NameRepository implements Container {

    public String names[] = {"Robert", "John", "Julie", "Lora"};

    public NameRepository() {
    }

    public NameRepository(String buffer) {
        names = buffer.split("");
    }

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    class NameIterator implements Iterator {

        Integer index = 0;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
