/*Jetbrains- DataStructure.
 * Avltree with index
 * Performance on all operation is O(logN) except for reIndex O(N) which only runs after 99000 times insert into spefic index
 * Enjoy!
 */
package com.mycompany.app;

import jdk.nashorn.internal.parser.TokenType;

public class AvlTree<AnyType> {

    private AvlNode<AnyType> root;
    private int countInsertIndex = 0;
    private int size = 0;

    public AvlTree() {
        root = null;
    }

    public int insertBack(double index, AnyType x) {
        //Check index out of bound
        if (root == null) {
            if (index != 0) {
                return -1;
            }
        }
        // Insert
        size++;
        root = insertBack(index, x, root);
        return 1;
    }

    public int insert(double index, AnyType x) {
        //Check index out of bound
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (root == null) {
            throw new IndexOutOfBoundsException();
        }

        if (countInsertIndex == 99000) {
            countInsertIndex = 0;
            reIndex(root);
        }

        // Insert in between 2 nodes or before node 0
        AvlNode<AnyType> curr = new AvlNode<AnyType>();
        AvlNode<AnyType> prev = new AvlNode<AnyType>();
        if (index > 0) {
            countInsertIndex++;
            prev = find(index - 1, root);
            curr = find(index, root);
            size++;
            root = insert(getNewPosition(curr.index, prev.index), x, root);
        } else if (index == 0) {
            curr = find(0, root);
            size++;
            root = insert(curr.index - 1, x, root);
        }

        return 1;
    }

    public int remove(double index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (root == null) {
            throw new IndexOutOfBoundsException();
        }

        root = remove(index, root);
        size--;
        return 1;
    }

    public AnyType findAndReplace(double index, AnyType newValue) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        //Check index out of bound
        if (root == null) {
            throw new IndexOutOfBoundsException();
        }

        return findAndReplace(index, newValue, root);
    }

    public void makeEmpty() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void printTree() {
        if (isEmpty()) {
            System.out.println("Empty tree");
        } else {
            printTree(root);
        }
    }

    public AnyType get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (root == null) {
            throw new IndexOutOfBoundsException();
        }

        return find(index, root).element;
    }

    /* Internal method */
    private static final int ALLOWED_IMBALANCE = 1;

    private AvlNode<AnyType> find(double index, AvlNode<AnyType> t) {
        if (t == null) {
            return null;
        }
        if (index == t.leftSubTreeNum) {
            return t;
        } else if (index < t.leftSubTreeNum) {
            return find(index, t.left);
        } else {
            return find(index - t.leftSubTreeNum - 1, t.right);
        }
    }

    private AvlNode<AnyType> insertBack(double index, AnyType x, AvlNode<AnyType> t) {
        if (t == null) {
            return new AvlNode<AnyType>(index, x, null, null);
        }

        if (index < t.index) {
            t.leftSubTreeNum++;
            t.left = insert(index, x, t.left);
        } else if (index > t.index) {
            t.right = insert(index, x, t.right);
        } else //Duplicate
        {
            ;
        }
        return balance(t);
    }

    private AvlNode<AnyType> insert(double index, AnyType x, AvlNode<AnyType> t) {
        if (t == null) {
            return new AvlNode<AnyType>(index, x, null, null);
        }
        /**
         * find the "index"th smallest node by index (use leftSubTreeNum)
         */
        if (index < t.index) {
            t.leftSubTreeNum++;
            t.left = insert(index, x, t.left);
        } else if (index > t.index) {
            t.right = insert(index, x, t.right);
        } else //Duplicate
        {
            ;
        }
        return balance(t);
    }

    /**
     * find the "index"th smallest node by index (use leftSubTreeNum)
     */
    private AvlNode<AnyType> remove(double index, AvlNode<AnyType> t) {
        if (t == null) {
            return t;
        }
        if (index < t.leftSubTreeNum) {
            t.leftSubTreeNum--;
            t.left = remove(index, t.left);
        } else if (index > t.leftSubTreeNum) {
            t.right = remove(index - t.leftSubTreeNum - 1, t.right);
        } else if (t.left != null && t.right != null) // Two children
        {
            AvlNode<AnyType> min = findMinForRemove(t.right);
            t.index = min.index;
            t.element = min.element;
            t.right = remove(0, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }

        return balance(t);
    }

    private AvlNode<AnyType> findMinForRemove(AvlNode<AnyType> t) {
        if (t == null) {
            return t;
        }
        while (t.left != null) {
            t = t.left;
        }
        return t;
    }

    private AvlNode<AnyType> findMax(AvlNode<AnyType> t) {
        if (t == null) {
            return t;
        }
        while (t.right != null) {
            t = t.right;
        }
        return t;
    }

    private AnyType findAndReplace(double index, AnyType newValue, AvlNode<AnyType> t) {
        if (index == t.leftSubTreeNum) {
            t.element = newValue;
            return t.element;
        } else if (index < t.leftSubTreeNum) {
            return findAndReplace(index, newValue, t.left);
        } else {
            return findAndReplace(index - t.leftSubTreeNum - 1, newValue, t.right);
        }
    }

    public void reIndex(AvlNode<AnyType> t) {
        if (t != null) {
            t.index *= 10000;
            reIndex(t.left);
            reIndex(t.right);
        }
    }

    private void printTree(AvlNode<AnyType> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.index + "  leftsub:" + t.leftSubTreeNum + "  element:" + t.element);
            printTree(t.right);

        }
    }

    private double getNewPosition(double end, double begin) {
        if (end - 0.00001 > begin) {
            return end - 0.00001;
        } else if (end - 0.000001 > begin) {
            return end - 0.000001;
        } else {
            return (end + begin) / 2;
        }

    }

    private int height(AvlNode<AnyType> t) {
        return t == null ? -1 : t.height;
    }

    //Return the number of node in the right subtree
    private int numRightSubTree(AvlNode<AnyType> t) {
        int sum = 0;
        if (t == null) {
            return 0;
        }
        while (t != null) {
            sum = sum + t.leftSubTreeNum + 1;
            t = t.right;
        }
        return sum;
    }

    private AvlNode<AnyType> rotateWithLeftChild(AvlNode<AnyType> k2) {
        AvlNode<AnyType> k1 = k2.left;
        int numRight = numRightSubTree(k1.right);
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;

        k2.leftSubTreeNum = numRight;
        return k1;
    }

    private AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> k1) {
        AvlNode<AnyType> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;
        k2.leftSubTreeNum += (k1.leftSubTreeNum + 1);
        return k2;
    }

    private AvlNode<AnyType> doubleWithLeftChild(AvlNode<AnyType> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AvlNode<AnyType> doubleWithRightChild(AvlNode<AnyType> k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    private AvlNode<AnyType> balance(AvlNode<AnyType> t) {
        if (t == null) {
            return t;
        }

        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE) {
            if (height(t.left.left) >= height(t.left.right)) {
                t = rotateWithLeftChild(t);
            } else {
                t = doubleWithLeftChild(t);
            }
        } else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE) {
            if (height(t.right.right) >= height(t.right.left)) {
                t = rotateWithRightChild(t);
            } else {
                t = doubleWithRightChild(t);
            }
        }

        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    public void checkBalance() {
        checkBalance(root);
    }

    private int checkBalance(AvlNode<AnyType> t) {
        if (t == null) {
            return -1;
        }

        if (t != null) {
            int hl = checkBalance(t.left);
            int hr = checkBalance(t.right);
            if (Math.abs(height(t.left) - height(t.right)) > 1
                    || height(t.left) != hl || height(t.right) != hr) {
                System.out.println("OOPS!!");
            }
        }

        return height(t);
    }

    private static class AvlNode<AnyType> {

        public AvlNode() {
        }

        AvlNode(AnyType theElement) {
            this(0, theElement, null, null);
        }

        AvlNode(double in, AnyType theElement, AvlNode<AnyType> lt, AvlNode<AnyType> rt) {
            index = in;
            element = theElement;
            left = lt;
            right = rt;
            height = 0;
            leftSubTreeNum = 0;
        }

        AnyType element;
        double index;
        int leftSubTreeNum;
        AvlNode<AnyType> left;
        AvlNode<AnyType> right;
        int height;
    }

}
