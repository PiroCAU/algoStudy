import sys

input = sys.stdin.readline

target = input().strip()
bomb = input().strip()

while(target.find(bomb) != -1):
    target= target.replace(bomb, '')

print(target if len(target) != 0 else "FRULA")

'''
입력 받고
while(in)
    replace(bomb, '')
'''