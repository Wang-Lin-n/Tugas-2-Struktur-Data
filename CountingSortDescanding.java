public class CountingSortDescanding {
    
    public static void sort(char arr[])
    {
        int n = arr.length;
        char output[] = new char[n];
        int count[] = new int[256];

        for (int i = 0; i < 256; ++i)
            count[i] = 0;
        for (int i = 0; i < n; ++i)
            ++count[arr[i]];

        // cumulative counts for ascending order
        for (int i = 1; i < 256; ++i)
            count[i] += count[i - 1];
        for (int i = n - 1; i >= 0; --i)
        {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        // copy in reverse to produce descending order
        for (int i = 0; i < n; ++i)
            arr[i] = output[n - 1 - i];
    }

    public static void main(String[] args) 
    {
        char arr[] = {11, 33, 44, 22, 66, 56, 3, 8};
        
        sort(arr);
        System.out.println("data setelah diurutkan countingsort (descending)");
        for (int i = 0; i < arr.length; ++i)
            System.out.println((int)arr[i]);
    }
}
