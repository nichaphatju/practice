function solution(A) {
    // Implement your solution here
    let oddNum = new Set();
    let numMap = {};

    for(let i=0; i<A.length; i++){
        if(numMap[A[i]]){
            numMap[A[i]] += 1;
            if(oddNum.has(A[i])){
                oddNum.delete(A[i]);
            }
        }else{
            numMap[A[i]] = 1;
            oddNum.add(A[i])
        }
    }

    // console.log(oddNum)
    return oddNum.size > 0 ? oddNum.keys().next().value : 0;
}