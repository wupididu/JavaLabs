public class Main {
    void FirstTask(){
        int[] arr = new int[10];
        for (int i = 0; i< 10; i++){
            arr[i] = i;
        }

        int sum = 0;

        // for

        for (int i = 0; i< 10; i++){
            sum += arr[i];
        }

        System.out.println(sum);

        // while
        sum = 0;
        int i = 0;
        while (i < 10){
            sum += arr[i];
            i++;
        }
        System.out.println(sum);

        // do while

        sum = 0;
        i = 0;
        do{
            sum += arr[i];
            i++;
        }while(i < 10);
        System.out.println(sum);
    }
    void ThTask(){
        System.out.println(1);
        for (int i = 2; i<=10; i++){
            double n = i;
            System.out.println(1 + "/" + i + " ("+ 1/n+")");
        }
    }
    void RandomTask(){
        int[] randArr = new int[10];
        for(int i = 0; i < 10; i++){
            randArr[i] = (int)(Math.random()*100);
        }
        System.out.println("Array:");
        for(int i = 0; i < 10; i++){
            System.out.println(randArr[i]);
        }
        System.out.println("Sorted Array:");
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9-i; j++){
                if(randArr[j] > randArr[j+1]){
                    int temp = randArr[j];
                    randArr[j] = randArr[j+1];
                    randArr[j+1] = temp;
                }
            }
        }
        for(int i = 0; i < 10; i++){
            System.out.println(randArr[i]);
        }
    }
    int Factorial(int number){
        if(number > 1)
            return number*Factorial(number - 1);
        else if (number <= 1)
            return 1;
        return 0;
    }  // Реализация через рекурсию
    void LoopFact(int number){
        int res = 1;
        for (int i = 1; i <= number; i++)
            res *=i;
        System.out.println(res);
    }  // Реализация циклом

    public static void main(String[] args) {
        Main Task = new Main();
        //Task.FirstTask();
        //Task.ThTask();
        //Task.RandomTask();
        //System.out.println(Task.Factorial(13));
        // Task.LoopFact(13);
    }
}