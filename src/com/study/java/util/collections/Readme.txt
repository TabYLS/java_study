Collections是collection的工具类：
给collection集合排序有两种方式（和TreeSet的两种是一样的）：
static <T extends Comparable<? super T>> void sort(List<T> list)------>拥有比较性的对象存入到collection中都可以进行比较

static <T> void sort(List<T> list, Comparator<? super T> c) ---------->对于不具有比较性的对象，自定义一个比较器进行比较

 <T extends Comparable>：指定上限
 <? super T>		      ：制定下限