private static LinkedList<File> taskQueue = new LinkedList<File>();    
    private static void startTask() { 
        while (taskQueue.size() > 0) { 
            File dir = taskQueue.removeFirst(); 
            File[] files = dir.listFiles(); 
            for (File file : files) { 
                if (file.isFile() && (file.getName().endsWith(".java"))) { 
                    BufferedReader reader = null; 
                    try { 
                        reader = new BufferedReader(new FileReader(file)); 
                        while (reader.readLine() != null) { 
                            lineCount2++; 
                        } 
                    } catch (Exception e) { 
                        throw new RuntimeException(e); 
                    } finally { 
                        try { 
                            reader.close(); 
                        } catch (IOException e) { 
                            throw new RuntimeException(e); 
                        } 
                    } 
                } else if(file.isDirectory()){ 
                    taskQueue.addLast(file); 
                } 
            } 
