package ru.netology.javaqa;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTesting() {
        SimpleTask simpleTask = new SimpleTask(5, "Молоко");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Молоко",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] tasks = todos.search("Молоко");
        Task[] expected = new Task[]{
                simpleTask, epic, meeting
        };

        Assertions.assertArrayEquals(expected, tasks);
    }

    @Test
    public void searchTestingWithManyTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Молоко");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Молоко",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        SimpleTask simpleTask1 = new SimpleTask(4, "Молоко");

        String[] subtasks1 = {"Молоко", "Яйца", "Хлеб"};
        Epic epic1 = new Epic(44, subtasks);

        Meeting meeting1 = new Meeting(
                444,
                "Молоко",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.add(simpleTask1);
        todos.add(epic1);
        todos.add(meeting1);
        Task[] tasks = todos.search("Молоко");

        Task[] expected = new Task[]{simpleTask,epic,meeting,simpleTask1,epic1,meeting1};
        Assertions.assertArrayEquals(expected, tasks);
    }

    @Test
    public void emptySearchTesting() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();
        todos.add(simpleTask);

        Assertions.assertEquals(0, todos.search("Молоко").length);
    }
}
