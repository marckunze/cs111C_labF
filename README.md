# cs111C_labF
Repostiory for CCSF CS111c Lab F project

# Part A: Binary Search Tree with Duplicates (68 points)

The class BinarySearchTreeWithDups represents a binary search tree in which duplicate entries are allowed.

* A duplicate entry is placed in the entrys right subtree, as described in the textbook Section 25.4.
* Essentially, if you hit a duplicate, go into the right subtree. Then continue to look for the right place to put the entry, just as you normally would in a BST.
* In this implementation, we will assume the getEntry method returns the first match it finds and the remove method removes the first match it finds. So the only modification required is the add method.

The class BinarySearchTreeWithDups extends BinarySearchTree,

* The class shell is provided with "???" as placeholders for the parts you will modify.
* There are many classes required to get this lab to compile. All are included in the provided zip. __You should only modify the BinarySearchTreeWithDups class.__
* Begin by closely reviewing BinarySearchTree and BinaryTree classes. Make sure you understand how these classes work before you implement BinarySeachTreeWithDups. You must have a good understanding of how the regular BST class works before you can make modifications. I cannot stress this enough!

## Implement BinarySearchTreeWithDups
1. Write an iterative addEntryHelperIterative method. (20 points)
    * In the BinarySearchTreeWithDups class, we override the add method to call a new private addEntryHelper method.
    * You will write this helper method. 
    * The helper method allows duplicate entries to be added, using the algorithm described above.
    * Important: This method must be written iteratively (not recursively) in order for Part B to run.
    * I recommend reviewing the addEntry method in BinarySearchTree class and then thinking about how to modify it.
2. Write a getAllEntriesRecursive method. (12 points)
      * This method returns an ArrayList of all the entries in a tree that match a target.
      * Use recursion. You can add a private helper method if necessary.
3. Write a getAllEntriesIterative method. (12 points)
      * Use iteration.
4. Write a getAllEntriesLessThanRecursive method. (12 points)
    * This method returns an ArrayList of all entries in the tree less than a target.
    * Use recursion. You can add a private helper method if necessary.
    * Note that the elements in the tree implement Comparable, so you can invoke the compareTo method.
5. Write a getAllEntriesLessThanIterative method. (12 points)
    * Use iteration.

### Test your program
* Use the driver program to test your methods. You might consider adding more tests to the driver.
* The first part of the driver shows how the regular BST class functions. The second part uses your implementation of the BinarySearchTreeWithDups.
* The zip file includes pictures of the two trees created by the driver.
* Make sure Part A is working properly before moving on to Part B!

# Part B: Big Data (32 Points)
Use the BinarySaarchTreeWithDups class to process a big data file.

* The data file is a list of San Francisco police incident reports for Larceny/Theft from 2003 to 2015 (downloaded from https://data.sfgov.org/Public-Safety/SFPD-Incidents-from-1-January-2003/tmnf-yvry)
    * There are over 370,000 records in the file. 
* I have provided two classes to process the file:
    * PoliceReport represents a single report.
    * ReportProcessor reads in the data file, creates a tree, and then uses the getAllEnrties method to create lists that match certain criteria.
      * In eclipse, place the data file in the same folder as the src/bin folders (so one level above the .java files).
* Review these files to become familiar with how they work.
    * At first, PoliceReport objects are compared/ordered by date (represented as a String). Two reports with the same date are considered "the same." You can see this in the equals and compareTo methods of the PoliceReport class.
        * Later, you will change this so that reports are compared/ordered by day of the week and incident number.
    * Note: I use a somewhat clunky/hacked method of identifying search criteria (creating a "dummyRecord" with only a single criteria on which to match). The proper way to do this would be to use Comparator objects or, better yet, the new Java 8 methods of filtering and matching streams. However, these programming concepts are beyond what you are expected to know for our course, so I used the more simpler (but rather inelegant!) approach. Please do not take this as an endorsement of this approach!
* Run and modify these files as described below and submit written answers to the following 7 questions.
1. Run the ReportProcessor.
    * Q1: How long did it take to build the tree?
    * Q2. For each of the 6 dates, list the number of incidents, the time it took to find those incidents using the tree, and the time it took to find those using the list.
2. In the ReportProcessor, comment out Part B-1. Un-comment Part B-2. In the PoliceReport file, comment out the two methods in Part B-1 and uncomment out the two methods in Part B-2.
    * You are now comparing and ordering reports by incident number. Incident numbers are unique, so there will no longer be duplicates in your tree.
3. Run the Report Processor.
    * Note: if you get an error, go back and make sure you made the changes in commented code in __both__ the PoliceReport and ReportProcessor files.
    * Q3: How long did it take to build the tree? Why do you think was it faster/slower than in Q1?
        * Hint: think about balance and depth/structure! Consider completing the extra credit now- it might help you answer this question!
    * Q4. For each of the 10 incident reports, list the time it took to find the report using the tree and the time it took to find the report using the list. 
4. In the ReportProcessor, comment out Part B-2. Un-comment Part B-3. In the PoliceReport file, comment out the two methods in Part B-2 and uncomment out the two methods in Part B-3.
    * You are now comparing and ordering reports by day of the week.
5. Run the ReportProcessor.
    * Q5: How long did it take to build the tree? Why do you think was it faster/slower than in Q1?
    * Q6. For each of the 7 days of the week, list the time it took to find those incidents using the tree and the time it took to find those incidents using the list. Why do you think it was faster/slower than in Q2?
    * Hint: think again about balance and depth/structure! 
6. In the ReportProcessor, comment out the line marked "??? ITERATIVE" and un-comment out the line marked "??? RECURSIVE."
7. Run the Report Processor.
    * Q7: What happens? The number of elements in the tree has not changed. So why does this happen?

## Extra Credit (20 Points)
Write a calculateLeftHeight and calculateRightHeight method in BinarySearchTreeWithDups. These methods calculate the height of the left and right subtrees (from the root). You can use recursion or iteration- it is your choice.

Re-run Part B-1 and B-2. List the left and right height of the trees created with these two different ways of comparing/ordering the reports.

### Submission
Zip __all__ files together and upload them for submission.

* Include the BinarySearchTreeWithDups class.
* Include the driver programs, interface files, and all supporting files in your zip, even though these files were not edited.
* Include your written answers to Part B in the zip.
