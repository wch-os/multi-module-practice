val board = rootDir
    .resolve("applications")
    .walkTopDown()     // 최상위부터 하위 디렉토리까지 탐색
    .maxDepth(5)       // 탐색 깊이 제한
    .filter(File::isDirectory)  // 디렉토리만 필터링
    .associateBy(File::getName) // 디렉토리 이름을 Key로 하고, File 객체를 Value로 하는 Map 생성


include(
    "board-application",
)

project(":board-application").projectDir = board["board-application"]!!