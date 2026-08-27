class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] components = path.split("/");

        for (String dir : components) {
            // Ignore empty strings (from consecutive slashes) and "." (current dir)
            if (dir.equals("") || dir.equals(".")) {
                continue;
            }
            
            if (dir.equals("..")) {
                // Pop parent directory if available
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Valid directory or filename (e.g. "a", "...", "....")
                stack.push(dir);
            }
        }

        // Reconstruct canonical path
        StringBuilder canonicalPath = new StringBuilder();
        // Deque iteration goes from bottom to top when using descendingIterator
        var iterator = stack.descendingIterator();
        while (iterator.hasNext()) {
            canonicalPath.append("/").append(iterator.next());
        }

        return canonicalPath.length() == 0 ? "/" : canonicalPath.toString();
    }
}