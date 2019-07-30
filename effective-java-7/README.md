#消除过期的对象引用



###Stack的过期引用

如果一个栈增长后收缩，那么从栈弹出的对象不会被垃圾收集，即使使用栈的程序
不再引用这些对象。 这是因为栈维护对这些对象的过期引用（ obsolete references）。 过期引用简单来说就是永远不
会解除的引用。 在这种情况下，元素数组“活动部分（active portion）”之外的任何引用都是过期的。 活动部分是由
索引下标小于 size 的元素组成。

```java



// Can you spot the "memory leak"?
public class Stack {
private Object[] elements;
private int size = 0;
private static final int DEFAULT_INITIAL_CAPACITY = 16;
public Stack() {
elements = new Object[DEFAULT_INITIAL_CAPACITY];
}
public void push(Object e) {
ensureCapacity();
elements[size++] = e;
}
public Object pop() {
if (size == 0)
throw new EmptyStackException();
return elements[--size];
}
/**
* Ensure space for at least one more element, roughly
* doubling the capacity each time the array needs to grow.
*/
private void ensureCapacity() {
if (elements.length == size)
elements = Arrays.copyOf(elements, 2 * size + 1);
}
}

```





这类问题的解决方法很简单：一旦对象引用过期，将它们设置为 null。

```java
public Object pop() {
if (size == 0)
throw new EmptyStackException();
Object result = elements[--size];
elements[size] = null; // Eliminate obsolete reference
return result;
}
```





### 缓存的内存泄漏

用 `WeakHashMap` 来表示缓存

### 监听器和其他回调

如果你实现了一个 API，其客户端注册回调，但是没有显式地
撤销注册回调，除非采取一些操作，否则它们将会累积。确保回调是垃圾收集的一种方法是只存储弱引用（weak
references），例如，仅将它们保存在 `WeakHashMap` 的键（key）中。



