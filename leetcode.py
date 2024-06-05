class BackTracking:

    def __init__(self):
        print("Hello")

    def subSet(string, ans, index):

        if index == len(string):
            print(ans)
            return

        BackTracking.subSet(string, ans + string[index], index + 1)
        BackTracking.subSet(string, ans, index + 1)

    def permutations(string, ans):
        if not string:
            print(ans)
            return

        for index in range(len(string)):
            current = string[index]
            remaining = string[:index] + string[index + 1:]
            BackTracking.permutations(remaining, ans + current)

    def main():
        BackTracking.permutations("abc", "")

# Call the main method
BackTracking.sanjay()
