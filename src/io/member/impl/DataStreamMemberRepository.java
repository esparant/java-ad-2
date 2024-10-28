package io.member.impl;

import io.member.Member;
import io.member.MemberRepository;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataStreamMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/members-data.dat";

    @Override
    public void add(Member member) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(FILE_PATH, true))) {
            dataOutputStream.writeUTF(member.getId());
            dataOutputStream.writeUTF(member.getName());
            dataOutputStream.writeInt(member.getAge());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> getMembers() {
        List<Member> members = new ArrayList<>();
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(FILE_PATH))) {
            while (dataInputStream.available() > 0) {
                members.add(new Member(dataInputStream.readUTF(), dataInputStream.readUTF(), dataInputStream.readInt()));
            }
            return members;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
