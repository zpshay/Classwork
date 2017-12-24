open("rat.in") do f
  for ln in eachline(f)
    print("$(length(ln)), $ln")
  end
end
