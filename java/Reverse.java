public class Reverse {
    
    public void reverse(char[] str) {
        int n = str.length;
        for (int i = 0; i < n / 2; i++) {
            swap(str, i, n - i - 1);
        }
    }

    private void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    // Two pointers
    public void reverse2Pointers(char[] str) {
        int i = 0;
        int j = str.length - 1;
        while (i < j) {
            swap(str, i, j);
            i++;
            j--;
        }
    }
}
