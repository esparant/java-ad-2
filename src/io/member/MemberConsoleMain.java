package io.member;

import io.member.impl.DataStreamMemberRepository;
import io.member.impl.FileMemberRepository;
import io.member.impl.MemoryMemberRepository;
import io.member.impl.ObjectStreamMemberRepository;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MemberConsoleMain {

//    private static final MemberRepository repository = new MemoryMemberRepository();
//    private static final MemberRepository repository = new FileMemberRepository();
//    private static final MemberRepository repository = new DataStreamMemberRepository();
    private static final MemberRepository repository = new ObjectStreamMemberRepository();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. 회원 등록 | 2. 회원 목록 조회 | 3. 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    registerMember(scanner);
                    break;
                case 2:
                    showMemberList();
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 입력하세요.");
                    break;
            }
        }
    }

    private static void showMemberList() {
        System.out.println("== 회원 목록 ==");
        List<Member> members = repository.getMembers();
        if (members.isEmpty()) {
            System.out.println("회원이 존재하지 않습니다.");
        }
        IntStream.range(0, members.size())
                .forEach(i -> System.out.printf("%d. %s\n", i + 1, members.get(i).toString()));
        System.out.println("== 회원 목록 끝 ==");
    }

    private static void registerMember(Scanner scanner) {
        System.out.print("ID 입력: ");
        String id = scanner.nextLine();
        System.out.print("Name 입력: ");
        String name = scanner.nextLine();
        System.out.print("Age 입력: ");
        int age = scanner.nextInt();

        repository.add(new Member(id, name, age));
        System.out.println("가입이 완료되었습니다.");
    }
}
