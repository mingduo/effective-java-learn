#### 考虑实现Comparable接口

##### nagive examples

可能会溢出



    // BROKEN difference-based comparator - violates transitivity!
    
    static Comparator<Object> hashCodeOrder = new Comparator<>() {
        public int compare(Object o1, Object o2) {
            return o1.hashCode() - o2.hashCode();
        }
    };



##### postive examples

    **// Comparator based on static compare method**
    static Comparator<Object> hashCodeOrder = new Comparator<>() {
        public int compare(Object o1, Object o2) {
            return Integer.compare(o1.hashCode(), o2.hashCode());
        }
    };

or

    // Comparator based on Comparator construction method
    static Comparator<Object> hashCodeOrder =
            Comparator.comparingInt(o -> o.hashCode());


