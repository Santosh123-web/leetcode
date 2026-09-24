// Last updated: 9/24/2026, 9:58:44 PM
1class Solution {
2    // Defining the Project class within the Solution class
3    private static class Project {
4        int capital;
5        int profit;
6
7        Project(int capital, int profit) {
8            this.capital = capital;
9            this.profit = profit;
10        }
11    }
12
13    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
14        int n = profits.length;
15        List<Project> projects = new ArrayList<>();
16
17        // Creating list of projects with capital and profits
18        for (int i = 0; i < n; i++) {
19            projects.add(new Project(capital[i], profits[i]));
20        }
21
22        // Sorting projects by capital required
23        Collections.sort(projects, (a, b) -> a.capital - b.capital);
24
25        // Max-heap to store profits (using a min-heap with inverted values)
26        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
27        int i = 0;
28
29        // Main loop to select up to k projects
30        for (int j = 0; j < k; j++) {
31            // Add all profitable projects that we can afford
32            while (i < n && projects.get(i).capital <= w) {
33                maxHeap.add(projects.get(i).profit);
34                i++;
35            }
36
37            // If no projects can be funded, break out of the loop
38            if (maxHeap.isEmpty()) {
39                break;
40            }
41
42            // Otherwise, take the project with the maximum profit
43            w += maxHeap.poll();
44        }
45
46        return w;
47    }
48}