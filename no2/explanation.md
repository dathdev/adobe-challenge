# Explanation
The `find` command finds all the files inside the var/www directory recursively and pipe it to the `sed` command which in turn will use Regex to match all the old phone number instances and replace them with the new number. The `xargs` command only serves the purpose of passing the filenames found from the first command to execute the second command.
