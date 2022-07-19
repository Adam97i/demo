public class company {

    String name;
    // 每日工时
    int dayHour;
    // 月薪
    int salary;
    // 公积金比例
    double percent;
    // 公积金基数
    double percentSalary;
    // 年终月数
    double yearReward;

    company(String name, int dayHour, int salary, double percent, double percentSalary, double yearReward) {
        this.name=name;
        this.dayHour=dayHour;
        this.salary=salary;
        this.percent=percent;
        this.percentSalary=percentSalary;
        this.yearReward=yearReward;
        getSum();
    }


    public void getSum() {
        System.out.println("公司: " + name);
        double p = percentSalary * percent * 12;
        System.out.println("公积金 ： " + p * 2);
        // 扣掉公积金、养老保险
        double v = salary * 12 + salary * yearReward - p-p;
        System.out.println("工资 ： " + v);
        double sum = 2 * p + v;
        System.out.println("总和 ：" + sum);
        System.out.println("工薪: " + sum / 12 / 22 / dayHour);
        System.out.println();
    }


    public static void main(String[] args) {
        company alpha = new company("alpha", 8, 9500, 0.08, 9500, 2);
        company hangzhouBank = new company("hangzhouBank", 7, 12500, 0.05, 3000, 0);
        company hangzhouBankAdd = new company("hangzhouBankAdd", 8, 13500, 0.05, 3000, 0);
        company hundsun = new company("hundsun", 8, 11500, 0.12, 11500, 3);

    }
}
