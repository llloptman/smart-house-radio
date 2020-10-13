# 3 задание
## Формулы для вычисления цикломатической сложности в Jacoco
The formal definition of the cyclomatic complexity v(G) is based on the representation of a method's control flow graph as a directed graph:

v(G) = E - N + 2

Where E is the number of edges and N the number of nodes. JaCoCo calculates cyclomatic complexity of a method with the following equivalent equation based on the number of branches (B) and the number of decision points (D):

v(G) = B - D + 1

Based on the coverage status of each branch JaCoCo also calculates covered and missed complexity for each method. Missed complexity again is an indication for the number of test cases missing to fully cover a module. Note that as JaCoCo does not consider exception handling as branches try/catch blocks will also not increase complexity.
## Рекомендуемый порог цикломатической сложности кода
Я считаю, что нет какой-то определенной цифры для того, чтоб можно было сказать, что если мы ее достигним, то количество тестов будет оптимальным. Т.к. циклометрическая сложность считает не только ветвление(if), но и циклы(for).
Это значит, что для разных программ будет разный порог покрытия. Я бы придерживался основ тест дизайна и выбирал отпимальные тесты:
* проверка граничных значений
* использовать метод попарного сравнения
* использовать таблицу принятия решений

Или смотреть на статистику покрытия веток. Если у нас не тестируется условие, то явно что-то не так)
