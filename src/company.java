public class company {

    String name;
    // 每日工时
    int dayHour;
    // 月薪
    int salary;
    // 公积金比例
    double percent;
    // 公积金基数
    double fundBase;
    // 年终月数
    double yearReward;

    company(String name, int dayHour, int salary, double percent, double fundBase, double yearReward) {
        this.name=name;
        this.dayHour=dayHour;
        this.salary=salary;
        this.percent=percent;
        this.fundBase =fundBase;
        this.yearReward=yearReward;
        getSum();
    }


    public void getSum() {
        System.out.println("公司: " + name);
        double p = fundBase * percent * 12;
        System.out.println("公积金 ： " + p * 2);
        // 扣掉公积金、养老保险
        double v = salary * 12 + salary * yearReward - p-p;
        System.out.println("工资 ： " + v);
        double sum = 2 * p + v;
        System.out.println("总和 ：" + sum);
        System.out.println("时薪: " + sum / 12 / 22 / dayHour);
        System.out.println();
    }


    public static void main(String[] args) {
        company hundsun = new company("hundsun", 8, 11500, 0.12, 11500, 3);
        company alpha = new company("alpha", 8, 9500, 0.08, 9500, 2);
        company lingxi = new company("lingxi", 8, 14000, 0.12, 6000, 1);
        company wudong = new company("wudong", 8, 13000, 0.12, 13000, 3);
        company huaweiOD = new company("huaweiOD", 9, 15000, 0.12, 15000, 2);
    }
}
