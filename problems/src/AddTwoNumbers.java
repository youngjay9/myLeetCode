import java.util.Stack;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode firstNode = null;

    ListNode returnNode = null;

    ListNode tmpNode = l1;

    // num1
    // 將 ListNode 依序取出放至 stack
    Stack<ListNode> st1 = new Stack<>();
    while (tmpNode != null) {
      st1.push(tmpNode);
      tmpNode = tmpNode.next;
    }
    // 算出 num1
    int num1 = 0;
    //計算 num1 用的指數
    int power1 = st1.size() - 1;
    while (!st1.empty()) {
      tmpNode = st1.pop();
      num1 += tmpNode.val * Math.pow(10, power1);
      power1 -= 1;
    }

    // 將 ListNode 依序取出放至 stack
    tmpNode = l2;
    Stack<ListNode> st2 = new Stack<>();
    while (tmpNode != null) {
      st2.push(tmpNode);
      tmpNode = tmpNode.next;
    }
    int num2 = 0;
    //計算 num1 用的指數
    int power2 = st2.size() - 1;
    while (!st2.empty()) {
      tmpNode = st2.pop();
      num2 += tmpNode.val * Math.pow(10, power2);
      power2 -= 1;
    }

    int dividedNum = num1 + num2; // 被除數
    int answer = 0; // 商
    int mod = 0; // 餘數

    while (dividedNum > 0) {
      answer = dividedNum / 10;
      mod = dividedNum % 10;
      if (firstNode != null) {
        returnNode.next = new ListNode(mod);
        returnNode = returnNode.next;
      } else {
        firstNode = new ListNode(mod);
        returnNode = firstNode;
      }

      dividedNum = answer;
    }

    return firstNode;
  }

  public static void main(String[] args) {

    ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));

    ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

    ListNode returnNode = addTwoNumbers(l1, l2);

    while (returnNode != null) {
      System.out.println(returnNode.val);
      returnNode = returnNode.next;
    }


  }
}
