8 Puzzle solving using A star algorithm
for ai class

Process child
  generate fronteir node
  check if exists in hash
    yes) do nothing
    no)
  add to hash with current cost as value
  add to priority queue with current cost + heuristic

list of moves

main loop
  node
  process all children of node
  pop priority queue
  increment current cost
  append move to list
  if goal, finished
  if not return

