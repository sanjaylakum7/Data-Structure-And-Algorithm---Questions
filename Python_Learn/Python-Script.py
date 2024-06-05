def two_sum(nums, target):
    table = {}

    for i in range(len(nums)):
        if nums[i] <= target:
            complement = target - nums[i]
            if complement in table:
                return [table[complement], i]
            else:
                table[nums[i]] = i

    return [-1, -1]