package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        // TODO: Get average grade for all students in your team.
//        String[] members = gradeDB.getMyTeam().getMembers();
//        float grades = 0.0f;
//        for (String member : members) {
//            grades += gradeDB.getGrade(member, course).getGrade();
//        }
//        return grades / members.length;
        float total = 0;
        Team team = gradeDB.getMyTeam();
        for (String s: team.getMembers()) {
            Grade g = gradeDB.getGrade(s, course);

            total += g.getGrade();
        }
        return total / team.getMembers().length;
    }
}
