package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;
import workshop.book.entity.ReferenceBook;

public class StatisticsAnalyzer {

    // Ÿ�Ժ� ��� ���� ���
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> totalPriceMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            totalPriceMap.put(type, totalPriceMap.getOrDefault(type, 0) + pub.getPrice());
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> avgPriceMap = new HashMap<>();
        for (String type : totalPriceMap.keySet()) {
            int total = totalPriceMap.get(type);
            int count = countMap.get(type);
            avgPriceMap.put(type, (double) total / count);
        }

        return avgPriceMap;
    }

    // Ÿ�Ժ� ���ǹ� ���� ���
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> countMap = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        int total = publications.length;
        Map<String, Double> ratioMap = new HashMap<>();
        for (String type : countMap.keySet()) {
            int count = countMap.get(type);
            ratioMap.put(type, (count * 100.0) / total);
        }

        return ratioMap;
    }

    // Ư�� ���� ���ǹ� ���� ���
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int matchCount = 0;

        for (Publication pub : publications) {
            if (pub.getPublishingDate().startsWith(year)) {
                matchCount++;
            }
        }

        return (matchCount * 100.0) / publications.length;
    }

    // ��� ���� ���
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");

        System.out.println("=== Ÿ�Ժ� ��� ���� ===");
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        for (String type : avgPrices.keySet()) {
            System.out.println(type + " : " + df.format(avgPrices.get(type)) + "��");
        }

        System.out.println("\n=== ���ǹ� ���� ���� ===");
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        for (String type : distribution.keySet()) {
            System.out.println(type + " : " + df.format(distribution.get(type)) + "%");
        }

        System.out.println("\n=== 2007�⵵ ���� ���� ===");
        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");
        System.out.println("2007�⵵ ���� ����: " + df.format(ratio2007) + "%");
    }

    // Ÿ�� �Ǻ� ��ƿ
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "�Ҽ�";
        } else if (pub instanceof Magazine) {
            return "����";
        } else if (pub instanceof ReferenceBook) {
            return "����";
        } else {
            return "��Ÿ";
        }
    }
}