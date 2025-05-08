#https://leetcode.com/problems/sort-an-array/

class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        def merge(arr,l,m,r):
            left = arr[l:m+1]
            right = arr[m+1:r+1]

            i, j, k = l,0,0

            while j<len(left) and k < len(right): 
                if left[j] <= right[k]:
                    arr[i] = left[j]
                    j +=1
                else:
                    arr[i] = right[k]
                    k +=1
                i +=1

            while j < len(left):
                nums[i] = left[j]
                j += 1
                i += 1
            while k < len(right):
                nums[i] = right[k]
                k += 1
                i += 1

        
        def mergeSort(arr,l,r):
            if l == r:
                return
            
            m = (l + r) // 2
            mergeSort(arr,l,m)
            mergeSort(arr,m+1,r)
            merge(arr,l,m,r)
            return
        
        mergeSort(nums,0,len(nums))
        return nums