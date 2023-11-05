function solution(A) {
    // Implement your solution her
    // Example Input - Row = hospital, Col = schedule
    // 0 1 2 3
    // 1 [[1, 4, 9, 3], 
    // 2 [2, 5, 1, 8],
    // 3 [6, 8, 0, 10]]
    let docIds = new Set();
    let allschedules = 0;
    for(let h=0; h<A.length ; h++){
        for(let s=0; s< A[h].length; s++){
            docIds.add(A[h][s]);
            allschedules++;
        }
    }
    return Math.min(docIds.size, allschedules - docIds.size);
}

var result = solution(
    [[1, 1, 9, 3],  
    [2, 5, 1, 8], 
    [6, 8, 0, 10]]);
console.log(result);