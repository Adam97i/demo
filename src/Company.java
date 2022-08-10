import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
    public static void main(String[] args) {
        // 纯base 无绩效，公积金默认12%  公积金基数=社保基数=医保基数
        Company hd = new Company("hd", 8, 11500, 3);
        Company wd = new Company("wd", 8.2, 13500, 3);
        // 纯base,公积金基数和社保基数不同
        Company lx = new Company("lx", 8, 14000, 1, 8000, 0.12, 6000);
        // 月薪构成  base + 绩效
        Company oo = new Company("oo", 8.2, 15500, 2, 12500, 0.12);
        // 全部指定类型
        // 公司名称、工时、薪水、年终月数、公积金基数、公积金比例、社保基数、社保比例、医保基数
        Company al = new Company("al", 8, 9500, 2, 9500, 0.08, 8000, 0.08, 8000);

        // 按时薪从高到低输出
        List<Company> list = new ArrayList<>();
        list.add(hd);
        list.add(wd);
        list.add(lx);
        list.add(oo);
        list.add(al);

        Collections.sort(list, (x, y) -> (int) (y.hourSalary - x.hourSalary));
        System.out.println("---------时薪排序---------");
        list.forEach(e -> {
            System.out.println(e.name + " : " + String.format("%.1f", e.hourSalary));
        });
        // 打印详细信息
        list.forEach(e -> e.print());

//        Collections.sort(list, (x, y) -> (int) (y.sum - x.sum));
//        System.out.println("---------收入排序---------");
//        list.forEach(e -> {
//            System.out.println(e.name +" : "+String.format("%.1f", e.sum));
//        });
//        list.forEach(e -> e.print());

    }


    String name;
    // 每日平均工时
    double dayHour;
    // 月薪
    int salary;
    // 医保基数
    double healthBase;
    // 社保比例
    double oldPercent;
    // 社保基数
    double oldBase;
    // 公积金比例
    double fundPercent;
    // 公积金基数
    double fundBase;
    // 年终月数
    double yearReward;
    // 总和（现金+公积金）
    double sum;
    // 时薪
    double hourSalary;

    /**
     * 以下为中间计算变量
     */
    // 个人月公积金
    double fund;
    // 个人月社保
    double old;
    // 个人月医保失业 按2.5%计算
    double health;
    // 个人所得税基数
    double selfBase;
    // 个人所得税
    double selfSalary;
    // 月现金
    double monthCash;
    // 年终奖
    double yearMoney;
    // 年终奖现金
    double yearMoneyCash;
    // 年现金
    double yearCash;
    // 年公积金
    double yearFund;

    /**
     * 全部指定类型
     * 公司名称、工时、薪水、年终月数、公积金基数、公积金比例、社保基数、社保比例、医保基数
     */
    Company(String name, double dayHour, int salary, double yearReward, double fundBase, double fundPercent, double oldBase, double oldPercent, double healthBase) {
        this.name = name;
        this.dayHour = dayHour;
        this.salary = salary;
        this.fundPercent = fundPercent;
        this.fundBase = fundBase;
        this.yearReward = yearReward;
        this.oldBase = oldBase;
        this.oldPercent = oldPercent;
        this.healthBase = healthBase;
        calculate();
    }

    /**
     * 月薪构成 纯base,公积金基数和社保基数不同， 社保基数=医保基数
     */
    Company(String name, double dayHour, int salary, double yearReward, double fundBase, double fundPercent, double oldBase) {
        this.name = name;
        this.dayHour = dayHour;
        this.salary = salary;
        this.fundPercent = fundPercent;
        this.fundBase = fundBase;
        this.yearReward = yearReward;
        this.oldBase = oldBase;
        this.oldPercent = 0.08;
        this.healthBase = oldBase;
        calculate();
    }

    Company(String name, double dayHour, int salary, double yearReward, double fundBase, double fundPercent) {
        this.name = name;
        this.dayHour = dayHour;
        this.salary = salary;
        this.fundPercent = fundPercent;
        this.fundBase = fundBase;
        this.yearReward = yearReward;
        this.oldBase = fundBase;
        this.healthBase = fundBase;
        this.oldPercent = 0.08;
        calculate();
    }

    /**
     * 月薪构成 纯base 无绩效，公积金默认12%，base =公积金基数=社保基数=医保基数
     */
    Company(String name, double dayHour, int salary, double yearReward) {
        this.name = name;
        this.dayHour = dayHour;
        this.salary = salary;
        this.fundPercent = 0.12;
        this.fundBase = salary;
        this.yearReward = yearReward;
        this.oldBase = salary;
        this.oldPercent = 0.08;
        this.healthBase = oldBase;
        calculate();
    }


    public void calculate() {
        // 个人月公积金
        this.fund = fundBase * fundPercent;
        // 个人月社保
        this.old = oldBase * oldPercent;
        // 个人月医保失业 按2.5%计算
        this.health = healthBase * 0.025;
        // 个人月所得税
        this.selfBase = salary - fund - old - health;
        this.selfSalary = getSelfSalary(selfBase);
        this.monthCash = salary - fund - old - health - selfSalary;
        this.yearMoney = yearReward * salary;
        this.yearMoneyCash = yearMoney - getSelfSalary(yearMoney);
        this.yearCash = monthCash * 12 + yearMoneyCash;
        this.yearFund = fund * 2 * 12;
        this.sum = yearCash + yearFund;
        // 每月平均22天
        this.hourSalary = sum / 12 / 22 / dayHour;

    }

    public void print() {
        System.out.println("---------" + name + "---------");
        System.out.println();
        System.out.println("---月度统计---");
        System.out.println("现金 : " + String.format("%.1f", monthCash));
        System.out.println("公积金 : " + fund * 2);
        System.out.println("社保 : " + old);
        System.out.println("医保 : " + health);
        System.out.println("个人所得税 : " + String.format("%.1f", selfSalary));
        System.out.println();
        System.out.println("---年度统计---");
        System.out.println("现金 : " + String.format("%.1f", yearCash) + "     其中工资 : " + String.format("%.1f", monthCash * 12) + "  年终奖: " + String.format("%.1f", yearMoneyCash));
        System.out.println("公积金 : " + yearFund);
        System.out.println("总和 : " + String.format("%.1f", sum));
        System.out.println("时薪 : " + String.format("%.1f", hourSalary));
        System.out.println();
    }


    /**
     * 个人所得税，起征点为5000，这里只计算1档 3%  2档 10%
     * 1档为扣除后不超过36000的部分
     * 2档为超过36000-144000的部分
     */
    private double getSelfSalary(double num) {
        double base = num - 5000;
        if (base <= 0) return 0;
        if (base < 36000) return base * 0.03;
        if (base < 144000) return 36000 * 0.03 + (base - 36000) * 0.1;
        return 0;
    }


}
