package org.example.reflection;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException {
        // ClassLoad 당시에 생성된 인스턴스 접근
        Class<Book> bookClass = Book.class;

        // 직접 생성하여 클래스 인스턴스에 접근
        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();

        //패키지 경로로 클래스 인스턴스에 접근
        Class<?> aClass1 = Class.forName("org.example.reflection.Book");

        //getFields()는 public 접근지시자의 필드만 읽어올 수 있음
        Arrays.stream(bookClass.getFields()).forEach(System.out::println);

        //getDeclaredFields 는 모든 필드를 가져옴
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);

        //Book Class의 모든 필드의 값 가져오기
        Arrays.stream(bookClass.getDeclaredFields()).forEach(
                f -> {
                    //private field 접근 허용하기
                    try {
                        f.setAccessible(true);
                        System.out.printf("%s %s\n", f, f.get(book));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
        );

        //Book Class의 모든 생성자 가져오기
        Arrays.stream(bookClass.getConstructors()).forEach(System.out::println);

        //Book Class의 모든 인터페이스 가져오기
        Arrays.stream(bookClass.getInterfaces()).forEach(System.out::println);

        //Book Class 접근지시자 알아내기
        Arrays.stream(bookClass.getDeclaredFields()).forEach(
                f -> {
                    int modifier = f.getModifiers();
                    System.out.println(Modifier.isFinal(modifier));
                    System.out.println(Modifier.isPublic(modifier));
                    System.out.println(Modifier.isPrivate(modifier));
                    System.out.println(Modifier.isProtected(modifier));
                }
        );

        //Book Class 메소드 가져오기
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);

        //Book Class 부모 클래스 가져오기
        System.out.println(bookClass.getSuperclass());

    }
}
