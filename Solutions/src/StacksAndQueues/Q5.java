package StacksAndQueues;

import java.util.Stack;

public class Q5 {

    // الدالة الرئيسية
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        
        // إدخال العناصر غير مرتبة
        s1.push(7);
        s1.push(10);
        s1.push(8);
        s1.push(12);
        s1.push(5);

        System.out.println("Stack قبل الفرز: " + s1);
        
        // استدعاء الدالة لفرز المكدس
        sortStack(s1);
        
        System.out.println("Stack بعد الفرز: " + s1);
    }

    // دالة لفرز المكدس
    public static void sortStack(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<>(); // مكدس إضافي لتخزين العناصر مرتبة
        
        // الخطوات:
        while (!s1.isEmpty()) {
            // قم بسحب العنصر العلوي من s1
            int tmp = s1.pop();
            
            // قم بإزالة جميع العناصر الأكبر من tmp من s2 وإعادتها إلى s1
            while (!s2.isEmpty() && s2.peek() > tmp) {
                s1.push(s2.pop());
            }
            
            // أدخل tmp في المكان المناسب في s2
            s2.push(tmp);
        }
        
        // انسخ العناصر من s2 إلى s1 (للحفاظ على ترتيب العناصر في s1)
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
}
