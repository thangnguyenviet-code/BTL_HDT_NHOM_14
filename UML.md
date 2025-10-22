```mermaid
%% Sơ đồ lớp DNU Career Connect
classDiagram

%% Lớp User
class User {
  - id: int
  - username: String
  - passwordHash: String
  - role: String
  + User()
  + User(id: int, username: String, passwordHash: String, role: String)
  + getId(): int
  + setId(id: int): void
  + getUsername(): String
  + setUsername(username: String): void
  + getPasswordHash(): String
  + setPasswordHash(hash: String): void
  + getRole(): String
  + setRole(role: String): void
}

%% Lớp Student
class Student {
  - studentId: int
  - fullName: String
  - major: String
  - skills: List<String>
  + Student()
  + Student(studentId: int, fullName: String, major: String)
  + getStudentId(): int
  + setStudentId(id: int): void
  + getFullName(): String
  + setFullName(name: String): void
  + getMajor(): String
  + setMajor(major: String): void
  + getSkills(): List<String>
  + addSkill(skill: String): void
  + removeSkill(skill: String): void
}

%% Lớp Employer
class Employer {
  - employerId: int
  - companyName: String
  - field: String
  + Employer()
  + Employer(employerId: int, companyName: String, field: String)
  + getEmployerId(): int
  + setEmployerId(id: int): void
  + getCompanyName(): String
  + setCompanyName(name: String): void
  + getField(): String
  + setField(field: String): void
}

%% Lớp CV
class CV {
  - cvId: int
  - education: String
  - experience: String
  - skills: List<String>
  + CV()
  + CV(cvId: int, education: String, experience: String)
  + getCvId(): int
  + setCvId(id: int): void
  + getEducation(): String
  + setEducation(edu: String): void
  + getExperience(): String
  + setExperience(exp: String): void
  + getSkills(): List<String>
  + addSkill(skill: String): void
  + removeSkill(skill: String): void
}

%% Lớp JobPosting
class JobPosting {
  - jobId: int
  - title: String
  - description: String
  - requirements: String
  - deadline: LocalDate
  - status: String
  + JobPosting()
  + JobPosting(jobId: int, title: String, description: String)
  + getJobId(): int
  + setJobId(id: int): void
  + getTitle(): String
  + setTitle(title: String): void
  + getDescription(): String
  + setDescription(desc: String): void
  + getRequirements(): String
  + setRequirements(req: String): void
  + getDeadline(): LocalDate
  + setDeadline(date: LocalDate): void
  + getStatus(): String
  + setStatus(status: String): void
}

%% Lớp Application
class Application {
  - appId: int
  - applyDate: LocalDate
  - status: String
  + Application()
  + Application(appId: int, applyDate: LocalDate, status: String)
  + getAppId(): int
  + setAppId(id: int): void
  + getApplyDate(): LocalDate
  + setApplyDate(date: LocalDate): void
  + getStatus(): String
  + setStatus(status: String): void
}

%% Quan hệ
User <|-- Student
User <|-- Employer
Student "1" -- "1" CV
Student "1" -- "*" Application
Employer "1" -- "*" JobPosting
JobPosting "1" -- "*" Application